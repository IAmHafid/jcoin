pipeline {
    agent {
        label 'Smith'
    }

    environment {
        PATH = "${JAVA_HOME}/bin:${PATH}"  // Met à jour le PATH pour inclure le répertoire bin du JDK
    }

    stages {
        stage('Cloner le dépôt') {
            steps {
                echo 'Cloner le projet depuis le dépôt Git'
                git 'https://github.com/IAmHafid/jcoin.git'
            }
        }

        stage('Compiler') {
            steps {
                echo 'Utilisation du Gradle Wrapper pour nettoyer et compiler le projet'
                sh './gradlew clean build'
            }
        }

        stage('Tests unitaires') {
            steps {
                echo 'exécution des tests'
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

            emailext(
                subject: "Build ${currentBuild.fullDisplayName} - Test Results",
                body: """
                    Build ${currentBuild.fullDisplayName} finished with status: ${currentBuild.currentResult}.
                    Test summary:
                    Passed: ${currentBuild.testResult.totalPassed}
                    Failed: ${currentBuild.testResult.totalFailed}
                    Skipped: ${currentBuild.testResult.totalSkipped}
                    Full details at: ${env.BUILD_URL}
                """,
                to: 'hafid.meliani@pm.me',
                compressLog: true,
                attachments: '**/target/surefire-reports/*.xml' // Joindre les rapports JUnit
            )
        }
    }
}
