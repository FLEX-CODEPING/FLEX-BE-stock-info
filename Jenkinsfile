pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = credentials('docker-repo-credential')
        DOCKER_USERNAME = "${DOCKER_CREDENTIALS_USR}"
        GITHUB_TOKEN = credentials('github-access-token')
        SSH_CREDENTIALS = credentials('flex-server-pem')
        SLACK_CHANNEL = '#backend-jenkins'
        IMAGE_NAME = "${DOCKER_USERNAME}/flex-be-prod-stock-info"
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    slackSend(channel: SLACK_CHANNEL, message: "🏗️ stock-info Build #${env.BUILD_NUMBER} is starting...")
                    sh 'chmod +x gradlew'
                    sh './gradlew clean assemble -x test'
                }
            }
            post {
                success {
                    echo 'Gradle build success'
                    slackSend(channel: SLACK_CHANNEL, message: "✅ STOCK INFO build succeeded for Build #${env.BUILD_NUMBER}.")
                }
                failure {
                    echo 'Gradle build failed'
                    slackSend(channel: SLACK_CHANNEL, message: "⛔️ STOCK INFO build failed for Build #${env.BUILD_NUMBER}.")
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    def dockerImage = docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-repo-credential') {
                        dockerImage.push()
                        dockerImage.push('latest')
                    }
                    slackSend(channel: SLACK_CHANNEL, message: "🐳 Docker image built and pushed for Build #${env.BUILD_NUMBER}.")
                }
            }
        }

        stage('Update Helm Values YAML') {
            steps {
                script {
                    slackSend(channel: SLACK_CHANNEL, message: "🔄 Updating Helm values for Build #${env.BUILD_NUMBER}...")
                    git branch: 'main', credentialsId: 'github-signin', url: 'https://github.com/FLEX-CODEPING/FLEX-CD.git'
                    sh """
                    sed -i 's|tag: .*|tag: ${IMAGE_TAG}|' charts/stock-info-service/values.yaml
                    """
                    withCredentials([usernamePassword(credentialsId: 'github-access-token', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD')]) {
                        sh """
                        git config user.email "codepingkea@gmail.com"
                        git config user.name "${GIT_USERNAME}"
                        git add charts/stock-info-service/values.yaml
                        git commit -m "[UPDATE] stock-info-service image tag ${IMAGE_TAG}"
                        git push https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/FLEX-CODEPING/FLEX-CD.git main
                        """
                    }
                    slackSend(channel: SLACK_CHANNEL, message: "✅ Helm values.yaml updated for Build #${env.BUILD_NUMBER}.")
                }
            }
        }
    }
}