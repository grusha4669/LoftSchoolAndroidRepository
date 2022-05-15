package ru.pashaginas.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.pashaginas.myapplication.LoftApp
import ru.pashaginas.myapplication.MoneyItemDataClass
import ru.pashaginas.myapplication.R
import ru.pashaginas.myapplication.activities.MainActivity.Companion.FRAGMENT_TYPE
import ru.pashaginas.myapplication.adapters.MoneyItemsAdapter


//BudgetFragment
class BudgetFragment : Fragment() {
    private lateinit var itemsAdapter: MoneyItemsAdapter
    private lateinit var compositeDisposable: CompositeDisposable
    private var fragmentType: String? = null


    companion object {
        fun newInstance(colorId: Int, type: String?): BudgetFragment {
            val budgetFragment = BudgetFragment()
            val bundle = Bundle()
            bundle.putString(FRAGMENT_TYPE, type)
            budgetFragment.arguments = bundle
            return budgetFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        fragmentType = arguments?.getString(FRAGMENT_TYPE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_budget, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsAdapter = MoneyItemsAdapter()
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView_main)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView.adapter = itemsAdapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        )


    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData() {
        val disposable: Disposable =
            (requireActivity().application as LoftApp).moneyApi.getMoneyItems(fragmentType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ moneyResponse ->
                    if (moneyResponse.status.equals("success")) {
                        val moneyItems: MutableList<MoneyItemDataClass> =
                            ArrayList<MoneyItemDataClass>()
                        for (moneyRemoteItem in moneyResponse.moneyItemsList!!) {
                            moneyItems.add(MoneyItemDataClass.getInstance(moneyRemoteItem))
                        }
                        itemsAdapter.setList(moneyItems)
                    } else {
                        Toast.makeText(
                            context,
                            getString(R.string.add),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }) { throwable ->
                    Toast.makeText(
                        context,
                        throwable.getLocalizedMessage(),
                        Toast.LENGTH_LONG
                    ).show()
                }
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
