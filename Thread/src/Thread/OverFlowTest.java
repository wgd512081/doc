package Thread;
    public class OverflowTest {
        private volatile int i=0;
        private volatile int b=0;
        private volatile int c=0;

//	private  int i=0;
//	private  int b=0;
//	private  int c=0;

        public static void main(String[] args) {
            byte[] b = new byte[1*1024*1024];
            System.gc();
            System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
            System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
            System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
//            OverflowTest o=new OverflowTest();
//            try {
//                o.deepTest();
//            } catch (Throwable e) {
//                System.out.println("over flow deep:"+o.i);
//                e.printStackTrace();
//            }
        }
        private void deepTest() {
            ++i;
            ++b;
            ++c;
            deepTest();
        }

}