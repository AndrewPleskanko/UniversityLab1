package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable

//The constructor of the Animal class takes three parameters, which are used to
// initialize the three properties of the class.
data class Animals(val name: String?, val description: String?, val image: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    //write the data of the Animal class to a Parcel object
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    //use to create an Animal class object from a Parcel object
    companion object CREATOR : Parcelable.Creator<Animals> {
        override fun createFromParcel(parcel: Parcel): Animals {
            return Animals(parcel)
        }

        // to create a new object array class Animal
        override fun newArray(size: Int): Array<Animals?> {
            return arrayOfNulls(size)
        }
    }
}