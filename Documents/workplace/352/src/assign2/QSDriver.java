package assign2;
public class QSDriver{
		
	
	public static void main(String[]args){
		String sort= args[0];
		String gen = args[1];
		String length = args[2];//needs to be parsed
		String seed="n/a";//initial ; needs to be parsed
		long seedLong=0;
		boolean seedEntered = false;
		
		if(args.length==4){
			seed=args[3];
			seedLong=Long.parseLong(seed);
			seedEntered =true;
			}
		
		//string to int
		int size = Integer.parseInt(length);
	
		
		
		
		int[] a;
		long startTime = 0, endTime = 0;
		//two randomGen
		if(gen.compareTo("RandomGen")==0){
			a=RandomGen.generate(size);
			if(sort.compareTo("QSNormal")==0){
				startTime = System.nanoTime();
				QSNormal.sort(a);
				endTime= System.nanoTime();
				System.out.println("Took "+(endTime-startTime)+ "ns");
			}
			else if(sort.compareTo("QSMedian")==0){
				startTime = System.nanoTime();
				QSMedian.sort(a);
				endTime= System.nanoTime();
				System.out.println("Took "+(endTime-startTime)+ "ns");
			}
		}
		else if(gen.compareTo("RandomGen")==0&&seedEntered){
			a=RandomGen.generateWithSeed(size, seedLong);
			if(sort.compareTo("QSNormal")==0){
				startTime = System.nanoTime();
				QSNormal.sort(a);
				endTime= System.nanoTime();
				System.out.println("Took "+(endTime-startTime)+ "ns");
			}
			else if(sort.compareTo("QSMedian")==0){
				startTime = System.nanoTime();
				QSMedian.sort(a);
				endTime= System.nanoTime();
				System.out.println("Took "+(endTime-startTime)+ "ns");
			}
		}
		//fixed
		else if(gen.compareTo("FixedGen")==0){
			a=FixedGen.generate(size);
			if(sort.compareTo("QSNormal")==0){
				startTime = System.nanoTime();
				QSNormal.sort(a);
				endTime= System.nanoTime();
				System.out.println("Took "+(endTime-startTime)+ "ns");
			}
			else if(sort.compareTo("QSMedian")==0){
				startTime = System.nanoTime();
				QSMedian.sort(a);
				endTime= System.nanoTime();
				System.out.println("Took "+(endTime-startTime)+ "ns");
			}
		}
	
	
		
				

	
		
		

		
	}
}

