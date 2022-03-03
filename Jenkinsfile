pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk17'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/metaXIII/Jeux.git'

                // Run Maven on a Unix agent.
                bat "mvn clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
