/**
 * A process context.  This contains all information needed
 * by the file system which is specific to a process.
 * @author Ray Ontko
 */

public class ProcessContext
{

    /**
     * Number of last error.
     * <p>
     * Simulates the unix system variable:
     * <pre>
     *   extern int errno;
     * </pre>
     */
    int errno = 0;

    /**
     * The uid for the process.
     */
    private short uid = 1;

    /**
     * The gid for the process.
     */
    private short gid = 1;

    /**
     * The working directory for the process.
     */
    private String dir = "/root";

    /**
     * The umask for the process.
     */
    private short umask = 0000;

    /**
     * The maximum number of files a process may have open.
     */
    static int MAX_OPEN_FILES = 0;

    /**
     * The array of file descriptors for open files.
     * The integer file descriptors for kernel method calls
     * are indexes into this array.
     */
    FileDescriptor[] openFiles = new FileDescriptor[MAX_OPEN_FILES];

    /**
     * Construct a process context.  By default, uid=1, gid=1, dir="/root",
     * and umask=0000.
     */
    ProcessContext() {
        super() ;
    }

    /**
     * Construct a process context and specify uid, gid, dir, and umask.
     */
    ProcessContext( short newUid, short newGid, String newDir, short newUmask ) {
        super() ;
        uid = newUid ;
        gid = newGid ;
        dir = newDir ;
        umask = newUmask ;
    }

    /**
     * Set the process uid.
     */
    void setUid( short newUid ) {
        uid = newUid ;
    }

    /**
     * Get the process uid.
     */
    short getUid() {
        return uid ;
    }

    /**
     * Set the process gid.
     */
    void setGid( short newGid ) {
        gid = newGid ;
    }

    /**
     * Get the process gid.
     */
    short getGid() {
        return gid ;
    }

    /**
     * Set the process working directory.
     */
    void setDir( String newDir ) {
        dir = newDir ;
    }

    /**
     * Get the process working directory.
     */
    String getDir() {
        return dir ;
    }

    /**
     * Set the process umask.
     */
    public void setUmask( short newUmask ) {
        umask = newUmask ;
    }

    /**
     * Get the process umask.
     */
    public short getUmask() {
        return umask ;
    }
}