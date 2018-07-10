package top.littleTomato.clock.dagger;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import top.littleTomato.clock.data.DataDao;
import top.littleTomato.clock.data.PageFactory;
import top.littleTomato.clock.entities.MainPageItem;

@Module
public class DataModule {

    @Provides
    public List<MainPageItem> pages() {
        return PageFactory.createPages();
    }

    @Provides
    public DataDao dataDao() {
        return DataDao.getInstance();
    }

}
