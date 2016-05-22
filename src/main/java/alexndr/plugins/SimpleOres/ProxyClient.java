package alexndr.plugins.SimpleOres;
import alexndr.api.helpers.game.RenderItemHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ProxyClient extends ProxyCommon 
{
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
	} // end preInit
	
	@Override
    public void load(FMLInitializationEvent event)
    {
		super.load(event);
		RenderItemHelper.renderItemsAndBlocks(SimpleOres.plugin);
    } // end load
    
	@Override
    public void postInit(FMLPostInitializationEvent event) 
    { 
		super.postInit(event);
    } // end postInit()    

} // end class()
