pipeline {
    agent any

    tools {
        jdk 'Java17'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar'
            }
        }

        stage('Run App') {
            steps {
                sh '''
                nohup java -jar build/libs/*.jar > app.log 2>&1 &
                '''
            }
        }
    }
}










        
        
