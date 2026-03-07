pipeline {
    agent any

     tools {
        jdk 'JDK 21'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url:'https://github.com/CHINPEIWEN/Week7_assignment.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t calculator-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 9090:8080 calculator-app'
            }
        }
    }
}
