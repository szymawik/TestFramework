def nodeNameValue = 'Test node'

pipeline {
    agent {label nodeNameValue}

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
            post{
                    always{
                    archiveArtifacts artifacts:"target/**/*", fingerprint: true
                    cucumber"**/*.json"
                    }
                    }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }

    }
}