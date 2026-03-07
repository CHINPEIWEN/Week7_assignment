pipeline {
    agent any

    tools {
        jdk 'JDK 21'
        maven 'Maven3'
    }

    environment {
        IMAGE_NAME = "calculator-fx-app"
        CONTAINER_NAME = "calculator-container"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/CHINPEIWEN/Week7_assignment.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat '''
                docker stop %CONTAINER_NAME% || echo no container
                docker rm %CONTAINER_NAME% || echo no container
                docker run -d --name %CONTAINER_NAME% -p 8080:8080 %IMAGE_NAME%
                '''
            }
        }

    }

    post {
        success {
            echo 'Build and Docker deployment successful!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
