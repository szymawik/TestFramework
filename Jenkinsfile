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
            publishers {
                                                                            allure (['target/allure-results']) {}
                                                                        }
                    always{
                    archiveArtifacts artifacts:"target/**/*", fingerprint: true
                    cucumber"target/cucumber/*.json"
                    }
                    }

        }
        stage('Test2') {
            steps {


                echo 'Deploying....'
            }
        }

    }
}