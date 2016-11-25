stage name: 'test'
node {
    git 'https://github.com/toonborgers/cegeka-devops-training'
    docker.withImage('java:8-jre-alpine') {
        sh 'dev/gradlew -p dev clean test integrationTest'
    }
}