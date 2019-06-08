### Boon vs. Jackson (Afterburner) vs. Jsoniter



| Benchmark                               | Mode | Score  | Units |
|-----------------------------------------|------|--------|-------|
| JSONBenchmark.boonObjectDeserialize     | avgt | 91.875 | us/op |
| JSONBenchmark.boonObjectSerialize       | avgt | 38.510 | us/op |
| JSONBenchmark.boonRawDeserialize        | avgt | 43.313 | us/op |
| JSONBenchmark.jacksonObjectDeserialize  | avgt | 54.445 | us/op |
| JSONBenchmark.jacksonObjectSerialize    | avgt | 25.679 | us/op |
| JSONBenchmark.jacksonRawDeserialize     | avgt | 65.145 | us/op |
| JSONBenchmark.jsoniterObjectDeserialize | avgt | 31.086 | us/op |
| JSONBenchmark.jsoniterObjectSerialize   | avgt | 17.075 | us/op |
| JSONBenchmark.jsoniterRawDeserialize      | avgt | 15.433 | us/op |

This is a stupid simple test against a list of Users:

``  
{
    "id": 40,
    "username": "Lila",
    "tags": [
      "duis",
      "Lorem",
      "dolor",
      "in",
      "exercitation"
    ]
  }
  ``

##### Libraries:

 * [Jsoniter](http://jsoniter.com/)
 * [Jackson](http://codemirror.net/) 
 * [Boon](https://github.com/boonproject/boon)  
 
##### Tools:
 * [JMH](http://openjdk.java.net/projects/code-tools/jmh/) for benchmarks
