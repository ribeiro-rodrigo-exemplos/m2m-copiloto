import ch.qos.logback.classic.AsyncAppender
import ch.qos.logback.core.util.FileSize
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.FileSystemResource
import org.yaml.snakeyaml.Yaml

def static getAppProperties(){
    def appFile = 'application.yml' as File
    def appProperties
    def parser = new Yaml()

    if(appFile.exists())
        appProperties = parser.load(new FileInputStream(appFile))
    else
        appProperties = parser.load(new FileSystemResource(System.getProperty('spring.config.location')).inputStream)

    appProperties
}

def appProperties = getAppProperties()

def LOG_PATH = appProperties['logging']['path']
def LOG_ARCHIVE = "${LOG_PATH}/arquivados"
def LOG_FILE_NAME = 'copiloto'
def LOG_FILE_SIZE = appProperties['logging']['fileSize'] as String
def LOG_MAX_HISTORY = appProperties['logging']['maxHistory'] as Integer

appender('Console',ConsoleAppender){
    encoder(PatternLayoutEncoder){
        pattern = '%yellow([%thread]) - %green(%date{ISO8601}) - %highlight(%-5level) - %cyan(%logger{15}) - %msg%n'
    }
}

appender('File',RollingFileAppender){
    file = "${LOG_PATH}/${LOG_FILE_NAME}.log"
    rollingPolicy(TimeBasedRollingPolicy){
        fileNamePattern = "${LOG_ARCHIVE}/${LOG_FILE_NAME}-%d{yyyy-MM-dd}.log"
        maxHistory = LOG_MAX_HISTORY
        totalSizeCap = FileSize.valueOf(LOG_FILE_SIZE)
    }
    encoder(PatternLayoutEncoder){
        pattern = "[%thread] - %date{ISO8601} - %level - %logger - %msg%n"
    }
}

appender('AsyncFile',AsyncAppender){
    appenderRef('File')
}

logger('br.com.m2msolutions.copiloto',INFO,[
        'AsyncFile',
        'Console'
],false)

root(INFO,['Console'])