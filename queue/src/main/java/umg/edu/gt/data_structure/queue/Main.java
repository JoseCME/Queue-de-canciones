package umg.edu.gt.data_structure.queue;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayDeque;
import java.util.Queue;
import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class Main {
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	public static void main(String[] args) {
		
//        Queue<String> q = new ArrayDeque<>();
//        q.offer("A");
//        q.offer("B");
//        q.offer("C");

//        System.out.println(q.peek()); // A
//        System.out.println(q.poll()); // A
//        System.out.println(q.poll()); // B
//        System.out.println(q.isEmpty()); // false
//        logger.info("este es mi mensaje");
//        logger.error("este es mi mensaje");
        
        QueueLinked queue = new QueueLinked();
        queue.enqueue(10);//Es el primero
        queue.enqueue(20);// Seria el segundo
     // Estariamos asi 1.10 2.20
        queue.enqueuePriority(50); // es el primero en la cola
     // Estariamos asi 1.50 2.10 3.20
       queue.enqueue(30);//es el tercero
    // Estariamos asi 1.50 2.10 3.20 4.30
       
       System.out.println(queue.peek());   // Aca inspecciono cual hay de primero que es 50
       System.out.println(queue.dequeue()); // 50 aca elimino el primero que es 50 entonces 10 llega a ser 1.
        // Estariamos asi 1.10 2.20 3.30 
       System.out.println(queue.peek()); //Aca inspecciono cual hay de primero que es 10
     
        System.out.println(queue.size()); //  aca seria 3 por que estaria 1.10  2.20 3.30
       
        System.out.println(queue.dequeue()); // aca elimino el primero que es 10
        System.out.println(queue.size()); //quedaria como 2 
        System.out.println(queue.peek()); //Aca inspecciono cual hay de primero que es 20
        
      
    }

}
