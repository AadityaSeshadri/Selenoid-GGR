pipeline {
    agent any

    stages {
        stage('SCM') {
            steps {
                checkout scm 
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
