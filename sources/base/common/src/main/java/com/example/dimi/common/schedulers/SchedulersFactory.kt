package com.example.dimi.common.schedulers

import io.reactivex.Scheduler

interface SchedulersFactory {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun trampoline(): Scheduler

    fun newThread(): Scheduler

    fun io(): Scheduler
}