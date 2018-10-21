pipeline{
    agent any
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
            }
        }
        stage('Test'){
            steps{
               //sh 'rm build/test-results/**/*.xml'
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
            }
        }
    }
    post{
        always{
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true 
            //junit 'build/test-results/**/*.xml'
	        deleteDir() 	
        }
    }
}
