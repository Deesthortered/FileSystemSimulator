public class umask {
    public static final String PROGRAM_NAME = "umask" ;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: need only one arguments");
            System.exit(1);
        }

        try {
            short mode = Short.parseShort(args[0], 8);
            Kernel.initialize();

            int res = Kernel.umask( mode ) ;
            if( res < 0 ) {
                Kernel.perror( PROGRAM_NAME ) ;
                System.err.println( PROGRAM_NAME + ": cannot to change umask" ) ;
                Kernel.exit( 2 ) ;
            }
            System.out.println("Previous mask is " + Integer.toOctalString(res));

            Kernel.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
