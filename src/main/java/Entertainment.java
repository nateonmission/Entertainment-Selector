import java.util.List;
public class Entertainment
{
    public List<BestSellers> bestSellerList;
    public List<HitSongs> hitSongList;

        public Entertainment (List<BestSellers> bestSellerList, List<HitSongs> hitSongList)
        {
            this.bestSellerList =  bestSellerList;
            this.hitSongList = hitSongList;
        }
}
