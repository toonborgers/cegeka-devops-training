stage name: 'test'
node {
    git 'https://github.com/toonborgers/cegeka-devops-training'
    docker.image('java:8-jre').inside {
        sh 'dev/gradlew -p dev clean test integrationTest'
    }
}