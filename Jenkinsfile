pipeline {
    agent any

    stages {

        stage('Maven Clean Test') {
            steps {
                echo 'Nettoyage du Projet : ';
                sh 'mvn clean test';
            }
        }
        
        stage('Maven Compile') {
            steps {
                echo 'Construction du Projet : ';
                sh 'mvn compile';
            }
        }
      
    }
    }

