# JoltTestTool WIP!!!
A deployable jar that you can use to test your Jolt Transforms.

Currently under construction and absolutely non-functional!!!

## Running the Code
### Gradle
`./gradlew bootRun`
### Runnable Jar
Build:  
`./gradlew bootJar`  
Run:  
`java -jar build/libs/JoltTestTool-1.0-SNAPSHOT.jar`

### Docker Image
Build:  
`docker build . --tag jolt-test-tool`  
Run:  
`docker build . --progress=plain --tag jolt-test-tool`  
Push to Repository:  
```bash
docker login registry.example.com -u <username> -p <token>
docker tag jolt-test-tool registry/path/jolt-test-tool:version
docker push registry/path/jolt-test-tool:version
```

## Tech Stack
- Jolt (duh)
- Spring-Boot / SpringMVC
- Thymeleaf
- Bootstrap (the css/js framework)
- Gradle
- Docker (Optional)

## Examples
Stolen from the official website: https://jolt-demo.appspot.com/

**Json Input**:  
```JSON
{
  "rating": {
    "primary": {
      "value": 3
    },
    "quality": {
      "value": 3
    }
  }
}
```

**Jolt Spec**:
```JSON
[
  {
    "operation": "shift",
    "spec": {
      "rating": {
        "primary": {
          "value": "Rating",
          "max": "RatingRange"
        },
        "*": {
          "max":   "SecondaryRatings.&1.Range",
          "value": "SecondaryRatings.&1.Value",
          "$": "SecondaryRatings.&1.Id"
        }
      }
    }
  },
  {
    "operation": "default",
    "spec": {
      "Range": 5,
      "SecondaryRatings": {
        "*": {
          "Range": 5
        }
      }
    }
  }
]
```
