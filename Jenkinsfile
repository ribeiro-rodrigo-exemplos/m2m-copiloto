pipeline{
    agent any
    options{
        preserveStashes(buildCount:4) 
    }
    parameters{
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'release/candidate-1.1.1', name: 'BRANCH', type: 'PT_BRANCH' 
        string(name: 'Version', defaultValue:'1.0.0', description: 'Versão do aplicativo')
    }
    environment{
        CONFIG_LOCATION="/opt/copiloto/copiloto.yml" 
        CC = """${sh(returnStdout: true, script:'echo "clang"').trim()}"""
        EXIT_STATUS="""${sh(returnStatus:true,script:'exit 1')}"""
        SECRET_FILE = credentials('secret_file_test') 
        TOMCAT_AUTH = credentials('894b4f90-e63e-408a-a91a-2d1d41ed532b')
    } 
    stages{
        stage('Build'){
            steps{
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                //sh './gradlew build'
                sh './gradlew build -x test'
                stash includes: '**/build/**/*.jar', name: 'copiloto'
            }
        }
        stage('Test'){
            steps{
                sh 'rm build/test-results/**/*.xml || true'
                sh './gradlew check || true'
                junit 'build/test-results/**/*.xml'
            }
        }
        stage('Deploy'){
            when{
                expression{
                    currentBuild.result == null || currentBuild.result == 'SUCCESS' 
                }
            }
            environment{
                LOCAL_ENVIRONMENT="local env"
            }
            steps{
                echo "Realizando build..."
                echo "${env.LOCAL_ENVIRONMENT}"
                echo "local do java ${env.JAVA_HOME}"
                echo "${env.CC}"
                echo "${env.EXIT_STATUS}"
                echo "java -jar copiloto.jar --spring-config-location=${env.CONFIG_LOCATION}" 
                echo "secret file - ${SECRET_FILE}"
                echo "username and password ${TOMCAT_AUTH}"
                echo "username ${TOMCAT_AUTH_USR}"
                echo "password ${TOMCAT_AUTH_PSW}"
                echo "${params.Version}" 
                echo "${params.BRANCH}"

                withCredentials(bindings:[sshUserPrivateKey(
                    credentialsId:'ssh_key', 
                    keyFileVariable: 'SSH_KEY_FILE',
                    passphraseVariable: 'SSH_KEY', 
                    usernameVariable : 'SSH_USERNAME' 
                )]){

                    sh 'ssh -i $SSH_KEY_FILE $SSH_USERNAME@198.211.108.140 ifconfig'
        
                }
            }
        }
    }
    post{
        always{
            unstash 'copiloto'
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true 
            //junit 'build/test-results/**/*.xml'
	        //deleteDir() 	
        }
    }
}
