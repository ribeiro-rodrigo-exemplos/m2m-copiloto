pipeline{
    agent any 
    stages{
        stage('Build'){
            steps{
		deleteDir()
                sh './gradlew build'
            }
        }
        stage('Test'){
            steps{
               //sh 'rm build/test-results/**/*.xml'
                sh './gradlew check'
            }
        }
    }
    post{
        always{
            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true 
            junit 'build/test-results/**/*.xml'
        }
    }
}
