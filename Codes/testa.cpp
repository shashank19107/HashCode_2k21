#include <bits/stdc++.h>
using namespace std;


int main() {
    // your code goes here
    int td, ti, ts, tc, inc, out, l, score;
    string s;
    cin >> td >> ti >> ts >> tc>> score;
    map <string, int> street;
    map <int, int> isinc;
    map <int, int> isout;
    map <int, string> inname;
    for(int i=0;i<ts;i++){
        cin>>out;
        cin>>inc;
        isinc[inc]++;
        isout[out]++;
        cin>>s;
        inname[inc]=s;
        cin>>l;
        street.insert({s,inc});
    }
    for(int i=0;i<tc;i++){
        int n;
        cin>>n;
        for(int i=0;i<n;i++){
            string uh;
            cin>>uh;
        }
    }
    cout<<ti<<'\n';
    for (auto i : isinc){ 
        if(i.first%2==0){
            cout<<i.first<<'\n';
            cout<<'1'<<'\n';
            cout<<inname[i.first]<<" 1\n";
            //street.remove(inname[i.first]);
        }
        else{
            cout<<i.first<<'\n';
            cout<<i.second<<'\n';
            for(auto j: street){
                if(j.second==i.first){
                    if((j.first[0]=='e')&&(j.first[1]=='j')&&(j.first[2]=='j'))
                        cout<<j.first<<" 2\n";
                    else{
                        cout<<j.first<<" 1\n";
                    }
                }
            }
        }
    }
    return 0;
}