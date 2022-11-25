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
                echo 'shit'
            }


//             publishers {
//                         allure (['target/allure-results']) {}
//                     }

            post{

                    always{
                    echo 'shit3'
                    allure([
                                            includeProperties: false,
                                            jdk: '',
                                            properties: [],
                                            reportBuildPolicy: 'ALWAYS',
                                            results: [[path: 'target/allure-results']]
                                    ])
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