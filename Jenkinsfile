pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/CHINPEIWEN/Week7_assignment.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t calculator-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8080:8080 calculator-app'
            }
        }
    }
}
