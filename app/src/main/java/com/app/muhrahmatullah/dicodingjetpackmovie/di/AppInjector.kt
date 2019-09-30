package com.app.muhrahmatullah.dicodingjetpackmovie.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.app.muhrahmatullah.dicodingjetpackmovie.MovieApp
import dagger.android.support.AndroidSupportInjection

/**
 * Created by muh.rahmatullah on 2019-09-13.
 */
class AppInjector {
    companion object {
        fun init(app: MovieApp) {
            DaggerAppComponent
                .builder()
                .application(app)
                .build()
                .inject(app)
            app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityPaused(p0: Activity) {
                }

                override fun onActivityStarted(p0: Activity) {
                }

                override fun onActivityDestroyed(p0: Activity) {
                }

                override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                }

                override fun onActivityStopped(p0: Activity) {
                }

                override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                    handleActivity(p0)
                }

                override fun onActivityResumed(p0: Activity) {
                }

            })
        }

        private fun handleActivity(activity: Activity) {
            if (activity is FragmentActivity) {
                activity.supportFragmentManager
                    .registerFragmentLifecycleCallbacks(
                        object : FragmentManager.FragmentLifecycleCallbacks() {
                            override fun onFragmentCreated(
                                fm: FragmentManager,
                                f: Fragment,
                                savedInstanceState: Bundle?
                            ) {
                                if (f is Injectable) {
                                    AndroidSupportInjection.inject(f)
                                }
                                f.parentFragment?.childFragmentManager
                                    ?.registerFragmentLifecycleCallbacks(object: FragmentManager.FragmentLifecycleCallbacks(){
                                    override fun onFragmentCreated(
                                        fm: FragmentManager,
                                        f: Fragment,
                                        savedInstanceState: Bundle?
                                    ) {
                                        if (f is Injectable) {
                                            AndroidSupportInjection.inject(f)
                                        }
                                    }
                                }, true)
                            }
                        }, true
                    )
            }
        }
    }
}