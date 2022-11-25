pipeline {
//     agent {label 'Test node'}
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
            post{
                    always{
                    archiveArtifacts artifacts:"target/**/*", fingerprint: true
                    cucumber"**/*.json"
                    }
                    }
            steps{
            publishers {
                                    allure (['target/allure-results']) {}
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