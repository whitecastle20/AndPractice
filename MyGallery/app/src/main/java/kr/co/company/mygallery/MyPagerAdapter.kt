package kr.co.company.mygallery

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val items = ArrayList<Fragment>()

    // 프래그먼트의 개수
    override fun getCount(): Int {
        return items.size
    }

    // position 위치의 프래그먼트
    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    fun updateFragments(items: List<Fragment>){
        this.items.addAll(items)
    }
}