pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean verify -Dtest=Runner'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
        post{
        always{
        archiveArtifacts artifacts:"target/**/*", fingerprint: true
        cucumber"target/*.json"
        }
        }
    }
}