package llp.money.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import llp.money.R
import llp.money.db.AppDatabase
import llp.money.entity.P2p
import llp.money.entity.P2pcompany
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [StartFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class StartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_start, container, false)

            view.findViewById<Button>(R.id.button_StartFagment).setOnClickListener {

                Thread(Runnable {
                    val P2pcompanyDao =  AppDatabase.getInstance(this.context).p2pcompanyDao()
                    val p2pDao =  AppDatabase.getInstance(context).p2pDao()
                    val p2pcompany = P2pcompany()
                    p2pcompany.setName("人人贷")
                    p2pcompany.setBank("建设")

                    val id = P2pcompanyDao.insert(p2pcompany)
                    val p2p = P2p()
                    p2p.setP2pcompanyId(id)
                    p2p.setDateActual(Date())
                    p2p.setDateEnd(Date())
                    p2p.setDateFrom(Date())
                    p2p.setInterest(100.0)
                    p2p.setIsNormal(1)
                    p2p.setPrincipal(10000.0)
                    p2p.setRate(0.01)
                    p2p.setRateActual(0.10)
                    p2p.setType("u计划")
                    val aLong = p2pDao.insert(p2p)
                    if (aLong > 0) {
                        Log.i("add", ":+1")
                    }
                }).start()




                Navigation.findNavController(view).navigate(R.id.action_startFragment_to_p2pFragment)
            }
            return view
    }

}
