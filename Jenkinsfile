pipeline{
    agent any 
    stages{
        stage('Build'){
            steps{
                sh './gradlew build'
            }
        }
        stage('Test'){
            steps{
               //sh 'rm build/test-results/**/*.xml'
                sh './gradlew check'
            }
        }
        stage('Deploy'){
            when{
                expression{
                    currentBuild.result == null || currentBuild.result == 'SUCCESS' 
                }
            }
            steps{
                echo "Realizando build" 
            }
        }
    }
    post{
        always{
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true 
            junit 'build/test-results/**/*.xml'
	        deleteDir() 	
        }
    }
}
