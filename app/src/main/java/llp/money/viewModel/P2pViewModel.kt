package llp.money.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import llp.money.db.AppDatabase
import llp.money.entity.P2pVE
import llp.money.tools.ioThread

class P2pViewModel(app: Application) : AndroidViewModel(app) {
    val dao = AppDatabase.getInstance(app).p2pVEDao()

    companion object {
        /**
         * A good page size is a value that fills at least a screen worth of content on a large
         * device so the User is unlikely to see a null item.
         * You can play with this constant to observe the paging behavior.
         * <p>
         * It's possible to vary this with list device size, but often unnecessary, unless a user
         * scrolling on a large device is expected to scroll through items more quickly than a small
         * device, such as when the large device uses a grid layout of items.
         */
        private const val PAGE_SIZE = 10

        /**
         * If placeholders are enabled, PagedList will report the full size but some items might
         * be null in onBind method (PagedListAdapter triggers a rebind when data is loaded).
         * <p>
         * If placeholders are disabled, onBind will never receive null but as more pages are
         * loaded, the scrollbars will jitter as new pages are loaded. You should probably disable
         * scrollbars if you disable placeholders.
         */
        private const val ENABLE_PLACEHOLDERS = true
    }

    val allP2ps = LivePagedListBuilder(dao.loadAllForPaging(), PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
            .build()).build()



    fun insert(text: CharSequence) = ioThread {
        //dao.insert(P2pVE(id = 0, name = text.toString()))
    }

    fun remove(p2pVE: P2pVE) = ioThread {
       // dao.delete(p2pVE)
    }
}