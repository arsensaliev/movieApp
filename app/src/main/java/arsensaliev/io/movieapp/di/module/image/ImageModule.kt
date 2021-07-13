package arsensaliev.io.movieapp.di.module.image

import android.widget.ImageView
import arsensaliev.io.movieapp.mvp.model.image.IImageLoader
import arsensaliev.io.movieapp.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}