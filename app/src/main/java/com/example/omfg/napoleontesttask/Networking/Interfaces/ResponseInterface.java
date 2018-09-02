package com.example.omfg.napoleontesttask.Networking.Interfaces;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.List;

import AppObjects.Banner;

public interface ResponseInterface {
    public List<Banner> createGetBannerResponse();

    public List<AppObjects.Offer> createGetOffersResponse(LinearLayout linearLayout, LinearLayout linearLayout2, Context context);

}
