package top.littleTomato.clock.dagger;

import dagger.Component;
import top.littleTomato.clock.adpter.ListAdapter;
import top.littleTomato.clock.adpter.MainPageAdapter;
import top.littleTomato.clock.presenter.MainPresenter;
import top.littleTomato.clock.views.AboutActivity;
import top.littleTomato.clock.views.ListActivity;
import top.littleTomato.clock.views.MainActivity;

@Component(modules = {ActivityModule.class, DataModule.class})
public interface ActivityComponent {
    void inject(AboutActivity aboutActivity);

    void inject(MainActivity aboutActivity);

    void inject(MainPresenter presenter);

    void inject(MainPageAdapter adapter);

    void inject(ListActivity listActivity);

    void inject(ListAdapter adapter);

}
