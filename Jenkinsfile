pipeline {
    agent {
        docker {
            image 'maven:3.9.5-eclipse-temurin-17-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Scan') {
            steps {
                script {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=Ascastillo98_Trabajo-DevOps'
                }
            }
        }
    }
}
