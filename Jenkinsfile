pipeline {
    agent Slave

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

        }
    }
}
