pipeline{
    agent any
    environment{
        CONFIG_LOCATION="/opt/copiloto/copiloto.yml" 
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
                echo "java -jar copiloto.jar --spring-config-location=${env.CONFIG_LOCATION}" 
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
