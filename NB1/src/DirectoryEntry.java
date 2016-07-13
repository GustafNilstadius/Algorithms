/**
 *
 * @author bfelt
 * @author Gustaf Nilstadius
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }
    
    @Override
    public boolean equals (Object e){
    	if (e instanceof DirectoryEntry){
    		DirectoryEntry tmp = (DirectoryEntry) e;
    		return tmp.name.equals(this.name);
    	}
    	return false;
    }
    
}
