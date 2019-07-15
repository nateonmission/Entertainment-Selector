import java.util.List;
public class Entertainment
{
    // These are the lists of objects built from the Book and Music CSVs
    public List<BestSellers> bestSellerList;
    public List<HitSongs> hitSongList;

        public Entertainment (List<BestSellers> bestSellerList, List<HitSongs> hitSongList)
        {
            this.bestSellerList =  bestSellerList;
            this.hitSongList = hitSongList;
        }
}
