package Update;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.gmail.mike546378.FTBHelper.FTBHelper;

public class Check {
	private URL filesfeed;
	
	private FTBHelper plugin;
	public Check(FTBHelper plugin){
		this.plugin = plugin;	
	}
	String version;
	String link;
	String description;
	public boolean updateNeeded(){
		try {
			this.filesfeed = new URL("http://dev.bukkit.org/bukkit-plugins/ftbhelper/files.rss");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			InputStream input = filesfeed.openConnection().getInputStream();
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
			
			Node latestfile = document.getElementsByTagName("item").item(0);
			NodeList children = latestfile.getChildNodes();
			
			version = children.item(1).getTextContent().replaceAll("[a-zA-Z ]", "");
			link = children.item(3).getTextContent();
			description = children.item(5).getTextContent();
			System.out.println(plugin.getName());
			if(version != plugin.getConfig().getString("version")){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public String getVersion(){
		return version;
	}
	
	public String getLink(){
		return link;
	}
	
	public String getDescription(){
		return description;
	}
}
