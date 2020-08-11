package com.safetydetect.hms.test.safetydetect

import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.safetydetect.hms.test.R


class SafetyActivity : Activity(), View.OnClickListener {
    // UI Object
    private var txt_topbar: TextView? = null
    private var txt_appscheck: TextView? = null
    private var txt_sysintegrity: TextView? = null
    private var txt_urlcheck: TextView? = null
    private var txt_userdetect: TextView? = null
    private var txt_wifidetect: TextView? = null

    // Fragment Object
    private var fg1: Fragment? = null
    private var fg2: Fragment? = null
    private var fg3: Fragment? = null
    private var fg4: Fragment? = null
    private var fg5: Fragment? = null
    private var fManager: FragmentManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.safety_activity)
        fManager = fragmentManager
        bindViews()
        txt_sysintegrity!!.performClick()
    }

    private fun bindViews() {
        txt_topbar = findViewById(R.id.txt_topbar)
        txt_appscheck = findViewById(R.id.txt_appscheck)
        txt_sysintegrity = findViewById(R.id.txt_sysintegrity)
        txt_urlcheck = findViewById(R.id.txt_urlcheck)
        txt_userdetect = findViewById(R.id.txt_userdetect)
        txt_wifidetect = findViewById(R.id.txt_wifidetect)
        txt_appscheck!!.setOnClickListener(this)
        txt_sysintegrity!!.setOnClickListener(this)
        txt_urlcheck!!.setOnClickListener(this)
        txt_userdetect!!.setOnClickListener(this)
        txt_wifidetect!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val fTransaction: FragmentTransaction = fManager!!.beginTransaction()
        hideAllFragment(fTransaction)
        val id: Int = v.id
        if (id == R.id.txt_appscheck) {
            setSelected()
            txt_appscheck!!.isSelected = true
            txt_topbar!!.setText(R.string.title_activity_apps_check)
            if (fg1 == null) {
                fg1 =
                    SafetyDetectAppsCheckAPIFragment()
                fTransaction.add(R.id.ly_content, fg1)
            } else {
                fTransaction.show(fg1)
            }
        } else if (id == R.id.txt_sysintegrity) {
            setSelected()
            txt_sysintegrity!!.isSelected = true
            txt_topbar!!.setText(R.string.title_activity_sys_integrity)
            if (fg2 == null) {
                fg2 =
                    SafetyDetectSysIntegrityAPIFragment()
                fTransaction.add(R.id.ly_content, fg2)
            } else {
                fTransaction.show(fg2)
            }
        } else if (id == R.id.txt_urlcheck) {
            setSelected()
            txt_urlcheck!!.isSelected = true
            txt_topbar!!.setText(R.string.title_url_check_entry)
            if (fg3 == null) {
                fg3 =
                    SafetyDetectUrlCheckAPIFragment()
                fTransaction.add(R.id.ly_content, fg3)
            } else {
                fTransaction.show(fg3)
            }
        } else if (id == R.id.txt_userdetect) {
            setSelected()
            txt_userdetect!!.isSelected = true
            txt_topbar!!.setText(R.string.title_user_detect_entry)
            if (fg4 == null) {
                fg4 =
                    SafetyDetectUserDetectAPIFragment()
                fTransaction.add(R.id.ly_content, fg4)
            } else {
                fTransaction.show(fg4)
            }
        } else if (id == R.id.txt_wifidetect) {
            setSelected()
            txt_wifidetect!!.isSelected = true
            txt_topbar!!.setText(R.string.title_wifi_detect_entry)
            if (fg5 == null) {
                fg5 =
                    SafetyDetectWifiDetectAPIFragment()
                fTransaction.add(R.id.ly_content, fg5)
            } else {
                fTransaction.show(fg5)
            }
        }
        fTransaction.commit()
    }

    private fun setSelected() {
        txt_appscheck!!.isSelected = false
        txt_sysintegrity!!.isSelected = false
        txt_urlcheck!!.isSelected = false
        txt_userdetect!!.isSelected = false
        txt_wifidetect!!.isSelected = false
    }

    private fun hideAllFragment(fragmentTransaction: FragmentTransaction) {
        if (fg1 != null) {
            fragmentTransaction.hide(fg1)
        }
        if (fg2 != null) {
            fragmentTransaction.hide(fg2)
        }
        if (fg3 != null) {
            fragmentTransaction.hide(fg3)
        }
        if (fg4 != null) {
            fragmentTransaction.hide(fg4)
        }
        if (fg5 != null) {
            fragmentTransaction.hide(fg5)
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}