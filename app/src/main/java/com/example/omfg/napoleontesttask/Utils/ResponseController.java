package com.example.omfg.napoleontesttask.Utils;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.omfg.napoleontesttask.Networking.Requests.BannerRequst;
import com.example.omfg.napoleontesttask.Networking.Interfaces.ResponseInterface;
import com.example.omfg.napoleontesttask.Networking.Requests.OfferstGetRequest;

import java.util.ArrayList;
import java.util.List;

import AppObjects.Banner;
import AppObjects.Offer;

public class ResponseController implements ResponseInterface {

    @Override
    public List<Banner> createGetBannerResponse() {
        BannerRequst bannerRequst = new BannerRequst();
        List<Banner> banners = new ArrayList<>();
        banners = bannerRequst.getBanners();
        return banners;
    }

    @Override
    public List<Offer> createGetOffersResponse(LinearLayout linearLayout, LinearLayout linearLayout2,Context context) {
        List<Offer> offers = new ArrayList<>();

        OfferstGetRequest offerstGetRequest = new OfferstGetRequest(offers,linearLayout, linearLayout2,context);

        offers = offerstGetRequest.getOffers();


        return offers;
    }
}
