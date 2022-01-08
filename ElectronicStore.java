import java.util.HashMap;


public class ElectronicStore {

	private HashMap<String, electronic_device> store;
	private static ElectronicStore instance = null;
	
	private ElectronicStore()
	{
		store = new HashMap<>();
	}
	
	
	public static ElectronicStore getInstance()
	{
		if(instance == null)
			instance = new ElectronicStore();
		
		return instance;
	}

	
	public HashMap<String, electronic_device> getStore()
	{
		return store;
	}

	
	public void addDevice(electronic_device device)
	{
		this.store.put(device.getSerial_number(), device);
	}
	
	
	public void printDevices()
	{
		for(String serialNumber : store.keySet())
		{
			store.get(serialNumber).print();
		}
		
		System.out.println(store.keySet());
	}
}
