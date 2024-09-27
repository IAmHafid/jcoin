pipeline {
    agent any

    triggers {
        cron('10 * * * *')  // Déclenche le build toutes les heures à 10 minutes après l'heure
    }

    tools {
        jdk 'JDK_9'
    }

    stages {
        stage('Cloner le dépôt') {
            steps {
                // Cloner le projet depuis le dépôt Git
                git 'https://github.com/IAmHafid/jcoin.git'
            }
        }

        stage('Compiler') {
            steps {
                // Utilisation du Gradle Wrapper pour nettoyer et compiler le projet
                sh './gradlew clean build'
            }
        }

        stage('Tests unitaires') {
            steps {
                // Utilisation du Gradle Wrapper pour exécuter les tests
                sh './gradlew test'
            }
        }

        stage('Emballer') {
            steps {
                // Utilisation du Gradle Wrapper pour assembler le projet
                sh './gradlew assemble'
            }
        }

        /* stage('Déployer') {
            steps {
                // Déployer l'artefact (ex: via SCP, Docker, ou un autre outil de déploiement)
                echo 'Déploiement de l\'application sur l\'environnement de test...'
                sh 'scp build/libs *//*.jar user@server:/path/to/deploy'
            }
        } */
    }

    post {
        always {
            // Générer un rapport de test JUnit basé sur les résultats des tests Gradle
            junit '**/build/test-results/test/*.xml'
        }
        post {
            success {
                mail to: 'hafid.meliani@pm.me',
                     subject: "Build Successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "The build was successful! Check it out at ${env.BUILD_URL}"
            }
            failure {
                mail to: 'hafid.meliani@pm.me',
                     subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "The build has failed. Check the details at ${env.BUILD_URL}"
            }
        }
    }
}
