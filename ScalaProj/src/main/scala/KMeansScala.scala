import java.util.Random
import scala.math
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
object KMeansScala {
def Classification(p: (Double,Double), random:Array[(Double,Double)]): Int = {
var index = 0
var IntMax = Double.PositiveInfinity
for (i <- 0 to 2) 
{
var tempCtr = random(i)
var tempDist = math.sqrt(math.pow(p._1.toDouble - tempCtr._1.toDouble,2)+ math.pow(p._2.toDouble - tempCtr._2.toDouble,2))
if (tempDist < IntMax) 
{
IntMax = tempDist
index = i
}
}
index
}
def main(args: Array[String]) 
{
val logFile = "src/data/Q1_testkmean.txt"
val sc = new SparkContext("local", "K-Means App", "/path/to/spark-0.9.1-incubating",
List("target/scala-2.10/simple-project_2.10-1.0.jar"))
val logData = sc.textFile(logFile, 1).cache()
val points = sc.textFile(logFile, 1).map(line=>line.split(" ")).map(line=>(line(0).toDouble,line(1).toDouble))
var random =  points.takeSample(false, 3, 1000)
var i = 0
while(i < 11)
{
var pointClassification = points.map(p=> (Classification(p,random), (p,1.0)))
var centroid = pointClassification.reduceByKey((x,y)=>(((x._1._1 + y._1._1),(x._1._2 + y._1._2)),(x._2 + y._2)))
var recomputeCentroid = centroid.mapValues{ case (point, sum) => (point._1/sum,point._2/sum)}
if( i == 10 ){
var clusterPoints = pointClassification.mapValues{ case (point,count) => (point._1,point._2)}
recomputeCentroid.cogroup(clusterPoints).saveAsTextFile("src/data/output")
}
random = recomputeCentroid.values.toArray
i = i + 1
}
}
}

