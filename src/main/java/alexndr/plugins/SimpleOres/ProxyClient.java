package alexndr.plugins.SimpleOres;
import alexndr.api.helpers.game.RenderItemHelper;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


public class ProxyClient extends alexndr.plugins.SimpleOres.ProxyCommon 
{
	RenderItemHelper renderHelper = new RenderItemHelper(SimpleOres.plugin);
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		if(event.getSide() == Side.CLIENT) 
		{
			if (Settings.mythrilBow.isEnabled()) {
				renderHelper.addBowRenderDetails(SimpleOres.plugin, Content.mythril_bow);
			}
			if (Settings.onyxBow.isEnabled()) {
				renderHelper.addBowRenderDetails(SimpleOres.plugin, Content.onyx_bow);
			}
			renderHelper.renderItemsAndBlocks();
			renderHelper.renderItemStuff(event);
		}
	} // end preInit
	
	@Override
    public void load(FMLInitializationEvent event)
    {
		super.load(event);
    } // end load
    
	@Override
    public void postInit(FMLPostInitializationEvent event) 
    { 
		super.postInit(event);
    } // end postInit()    

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) 
	{
    	ModItems.registerModels();
    	ModBlocks.registerModels();
	}


} // end class()
